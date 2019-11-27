import React, { Component }from 'react';
import logo from './logo.svg';
import './App.css';
import Restorans from './containers/Restorans/Restorans';
import layout from './components/Layout/Layout';

class App extends Component{
  render(){
    return (
      <div>
        <layout>
          <Restorans />
        </layout>
      </div>
    );
  }
}

export default App;
