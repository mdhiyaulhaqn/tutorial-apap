import React from "react";

import Item from "./Item";

export default function List({ title, items, onItemClick, hidden}){
    if(items.length === 0){
        return(
            <>
                <div style={{textAlign: "center", paddingTop: "50px"}}>
                    <h5>Belum ada item yang dipilih</h5>
                    <p>Klik salah satu item di daftar Menu</p>
                </div>
            </>
        );
    }

    return (
        <>
            <h3 style={styles.heading}>{title}</h3>
            <div className="list-group">
                {}
                {items.map(item => (
                    <Item key={item.id} item={item} onChange={onItemClick} hidden={hidden}/>
                ))}
            </div>
        </>
    );
}

const styles = {
    heading: {
        fontFamily: "courier new"
    }
};
