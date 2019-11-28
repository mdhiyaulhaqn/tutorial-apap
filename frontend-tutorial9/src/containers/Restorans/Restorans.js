import React, { Component } from 'react';
import Restoran from '../../components/Restoran/Restoran';
import classes from './Restorans.module.css'
import axios from "../../axios-restoran";
import Modal from '../../components/Modal/Modal';
import Button from '../../components/Button/Button';

class Restorans extends Component{
    constructor(props){
        super(props)
        this.state = {
            restorans:[],
            filteredRestorans:[],
            isCreate: false,
            isEdit: false,
            isLoading: true,
            nama:  "",
            alamat: "",
            nomorTelepon: "",
            rating: "",
        }
    }

    componentDidMount(){
        this.loadRestorans();
    }

    loadRestorans = async () => {
        const fetchedRestorans =[];
        const response = await axios.get("/restorans");
        for(let key in response.data){
            fetchedRestorans.push({
                ...response.data[key]
            });
        }
        this.setState({
            restorans: fetchedRestorans,
            filteredRestorans: fetchedRestorans,
        });
    }

    addRestoranHandler = () => {
        this.setState({isCreate: true});
    }

    canceledHandler = () => {
        this.setState({isCreate: false, isEdit: false});
    }

    changeHandler = event => {
        const {name, value } = event.target;
        this.setState({ [name]: value});
    }

    submitAddRestoranHandler = event => {
        event.preventDefault();
        this.setState({ isLoading: true, nama: "", nomorTelepon: "", rating: "", alamat: ""});
        this.addRestoran();
        this.canceledHandler();
    }

    editRestoranHandler(restoran){
        this.setState({
            isEdit: true,
            idRestoran: restoran.idRestoran,
            nama: restoran.nama,
            nomorTelepon: restoran.nomorTelepon,
            rating: restoran.rating,
            alamat: restoran.alamat
        })
    }

    async addRestoran(){
        const restoranToAdd = {
            nama: this.state.nama,
            alamat: this.state.alamat,
            nomorTelepon: this.state.nomorTelepon,
            rating: this.state.rating
        };

        await axios.post("/restoran", restoranToAdd);
        await this.loadRestorans();
    }

    submitEditRestoranHandler = event => {
        console.log("editing")
        event.preventDefault();
        this.setState({ isLoading: true });
        this.editRestoran();
        this.canceledHandler();
    }

    async editRestoran(){
        const restoranToEdit = {
            idRestoran: this.state.idRestoran,
            nama: this.state.nama,
            alamat: this.state.alamat,
            nomorTelepon: this.state.nomorTelepon,
            rating: this.state.rating
        }

        await axios.put("/restoran/" + this.state.idRestoran, restoranToEdit);
        await this.loadRestorans();
        this.canceledHandler();
    }

    async deleteRestoranHandler(restoranId){
        await axios.delete('/restoran/' + restoranId);
        await this.loadRestorans();
    }

    renderForm(){
        const { isEdit } = this.state;
        return (
            <form>
                <input
                className={classes.Input}
                name="nama"
                type="text"
                placeholder="Nama"
                value={this.state.nama}
                onChange={this.changeHandler}
                />
                <input
                className={classes.Input}
                name="nomorTelepon"
                type="number"
                placeholder="Nomor Telepon"
                value={this.state.nomorTelepon}
                onChange={this.changeHandler}
                />
                <textarea
                className={classes.TextArea}
                name="alamat"
                type="text"
                placeholder="Alamat"
                value={this.state.alamat}
                onChange={this.changeHandler}
                />
                <input
                className={classes.Input}
                name="rating"
                type="number"
                placeholder="Rating"
                value={this.state.rating}
                onChange={this.changeHandler}
                />
                <Button btnType="Danger" onClick={this.canceledHandler}>
                    CANCEL
                </Button>
                <Button btnType="Success" onClick={
                    isEdit ? this.submitEditRestoranHandler : this.submitAddRestoranHandler}>
                    SUBMIT
                </Button>
            </form>
        );
    }

    renderSearchForm(){
        return(<form>
            <input
                name="search"
                type="text"
                placeholder="Search..."
                onChange={this.changeSearchHandler}
            ></input>
        </form>
        );
    }
    
    changeSearchHandler = event => {
        const {value } = event.target;
        this.searchHandler(value);
    }

    searchHandler(search){
        let array = []

        if(search.length === 0){
            this.setState({
                filteredRestorans: this.state.restorans 
            })
        } else {
            for(let index in this.state.restorans){
                if(search.toLowerCase() === this.state.restorans[index].nama.toLowerCase().slice(0, search.length)){
                    array.push(this.state.restorans[index])
                }
            }

            this.setState({
                filteredRestorans: array
            })
        }

        
        
    }
    // shouldComponentUpdate(nextProps, nextState){
    //     console.log("shouldComponentUpdate()");
    //     return true;
    // }

    // loadingHandler = () => {
    //     const currentIsLoading = this.state.isLoading;
    //     this.setState( {isLoading: !(currentIsLoading)} );
    //     console.log(this.state.isLoading);
    // }

    render(){
        // console.log("render()");
        return(
            <React.Fragment>
                <Modal show={this.state.isCreate || this.state.isEdit}
                    modalClosed={this.canceledHandler}>
                        {this.renderForm()}
                    </Modal>
                <div className={classes.Title}> All Restorans </div>
                <div className={classes.ButtonLayout}>
                    <button
                        className={classes.AddRestoranButton}
                        onClick={this.addRestoranHandler}
                        >
                            + Add New Restoran
                    </button>
                </div>
                <div>
                    {this.renderSearchForm()}
                </div>
                <div className={classes.Restorans}>
                    {this.state.filteredRestorans.map(restoran =>
                        <Restoran
                            key={restoran.id}
                            nama={restoran.nama}
                            alamat={restoran.alamat}
                            nomorTelepon={restoran.nomorTelepon}
                            edit={() => this.editRestoranHandler(restoran)}
                            delete={() => this.deleteRestoranHandler(restoran.idRestoran)}
                            />)
                        }
                </div>

                {/* <button onClick={this.loadingHandler}>changeState</button> */}
            </React.Fragment>
        );
    }
}

export default Restorans;