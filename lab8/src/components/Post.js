import React from 'react'

export default function Post({ id, title, author, handleClick }) {

    const postStyle = {
        width: '18rem'
    }
    const ownClick = () => {
        handleClick(id)//this id is back to HOC handleClick prop, which is Posts
        console.log(`Post : ${id}`)
    }

    return (
        <div className="card post-box" onClick={ownClick}>
            <div className="card-body">
                <h5 className="card-title">{title}</h5>
                <h6 className="card-subtitle mb-2 text-muted">Author: {author}</h6>
                <p className="card-text">Id: {id}</p>
            </div>
        </div>
    )
}
