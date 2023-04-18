
import React, {useState, useEffect} from 'react'
import Post from './Post'
import axios from 'axios'

export default function Posts({ fetchFlag, clickedItem }) {

    const [posts, setPosts] = useState([])
    
    const fetchPosts = () => {
        axios.get(`http://localhost:8080/api/v1/posts`)
            .then(res => {
                console.log(res)
                setPosts(res.data)
            })
            .catch(err => {
                console.log(err)
            })
    }

    useEffect(() => {
        fetchPosts();
    }, [fetchFlag])

    const handleClick = (id) => {
        clickedItem(id)//this id is bind back to HOC handleClick prop, which is Dashboard
        console.log(`Posts : ${id}`)
    }
    return (
        <div>
            <div className='postboxcontainer'>
                {
                    posts.map(s =>
                        <Post key={s.id} id={s.id} title={s.title} author={s.author} handleClick={handleClick} />
                        //handleClick={(id) => handleClick(id)} 
                        //- 1st id is return from child component
                        //- 2nd id is pass that id to handlClick func above
                    )
                }
            </div>

        </div>
    )
}
