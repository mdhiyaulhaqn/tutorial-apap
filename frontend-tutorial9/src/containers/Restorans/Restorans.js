import React, { Component } from 'react';
import Restoran from '../../components/Restoran/Restoran';
import classes from './Restorans.module.css'

class Restorans extends Component{
    constructor(props){
        super(props)
        this.state = {
            restorans:
            [
                {id: 1, nama: "Restoran A", alamat: "This is address Restoran A", nomorTelepon: "021735313"},
                {id: 2, nama: "Restoran B", alamat: "This is address Restoran B", nomorTelepon: "021120491"},
                {id: 3, nama: "Restoran C", alamat: "This is address Restoran C", nomorTelepon: "021940256"},
            ],
            isLoading: true
        }
    }

    // componentDidMount(){
    //     console.log("componentDidMount()");
    // }

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
                <div className={classes.Title}> All Restorans </div>
                <div className={classes.Restorans}>
                    {this.state.restorans.map(restoran =>
                        <Restoran
                            key={restoran.id}
                            nama={restoran.nama}
                            alamat={restoran.alamat}
                            nomorTelepon={restoran.NomorTelepeon}
                            />)
                        }
                </div>

                {/* <button onClick={this.loadingHandler}>changeState</button> */}
            </React.Fragment>
        );
    }
}

export default Restorans;