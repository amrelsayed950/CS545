import React from 'react'

export default function Post({ id, title, author, handleClick }) {

    const ownClick = () => {
        handleClick(id)
        console.log(`Post : ${id}`)
    }

    return (
        <div className='post-box' onClick={ownClick}>
            <div><label>Id:</label><span>{id}</span></div>
            <div><label>Title: </label><span>{title}</span></div>
            <div><label>Author: </label><span>{author}</span></div>
        </div>
    )
}
