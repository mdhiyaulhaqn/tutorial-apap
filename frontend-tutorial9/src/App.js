import React, { Component }from 'react';
import logo from './logo.svg';
import './App.css';
import Restorans from './containers/Restorans/Restorans';
import Layout from './components/Layout/Layout';

class App extends Component{
  render(){
    return (
      <React.Fragment>
        <Layout>
          <Restorans />
        </Layout>
      </React.Fragment>
    );
  }
}

export default App;
