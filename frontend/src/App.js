import React from 'react';
import List from "./components/List";
import dummyItems from "./items.json";

export default class App extends React.Component{
  constructor(props){
    super(props);
    this.state={
      checked: false,
      favItems: [],

    };
    this.handleShowFavorite =  this.handleShowFavorite.bind(this);
  }

  handleItemClick = item => {
    const newItems = [...this.state.favItems];
    const newItem = { ...item };

    const targetInd = newItems.findIndex(it => it.id === newItem.id);
    console.log(targetInd);
    if(targetInd < 0) newItems.push(newItem);
    else newItems.splice(targetInd, 1);

    this.setState({ favItems: newItems});
  };

    handleShowFavorite() {
        this.setState({
            checked: !this.state.checked
        })
    }

    render(){
      const { favItems } = this.state;

      return(
          <div className="container-fluid">
            <h1 className="text-center">
                Welcome !
              <small>Class-based</small>
            </h1>
            <div style={{textAlign:"right"}}>
                <label><input type="checkbox" onChange={this.handleShowFavorite}/> Show Favorit</label>
            </div>
            <div className="container pt-3">
              <div className="row">
                <div className="col-sm">
                  <List
                    title="Our Menu"
                    items={dummyItems}
                    onItemClick={this.handleItemClick}
                    hidden={true}
                    />
                </div>
                <div className="col-sm" hidden={!this.state.checked}>
                  <List
                    title="My Favorite"
                    items={favItems}
                    onItemClick={this.handleItemClick}
                    hidden={false}
                    />
                </div>
              </div>
            </div>
          </div>
      );
    }
}
