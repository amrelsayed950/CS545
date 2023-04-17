import React, { useState } from 'react'
import Post from './Post'

export default function Posts({ list, clickedItem }) {

    const [detailFlag, setDetailFlag] = useState(false)
    
    const [item, setItem] = useState({})

    const handleClick = (id) => {
        clickedItem(id)
        console.log(`Posts : ${id}`)
    }
    return (
        <div>
            <div className='post-box-container'>
                {
                    list.map(s =>
                        <Post key={s.id} id={s.id} title={s.title} author={s.author} handleClick={(id) => handleClick(id)} />
                        //handleClick={(id) => handleClick(id)} 
                        //- 1st id is return from child component
                        //- 2nd id is pass that id to handlClick func above
                    )
                }
            </div>
            
        </div>
    )
}
