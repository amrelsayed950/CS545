import React, { useState } from 'react'
import PostDetail from '../components/PostDetail'
import Posts from '../components/Posts'

export default function Dashboard() {
    const [posts, setPosts] = useState([
        {
            id: '111',
            title: 'Happiness',
            author: 'John',
            content: 'Content of the Post 1 Happiness'

        },
        {
            id: '112',
            title: 'MIU',
            author: 'Dean',
            content: 'Content of the Post 2 MIU'

        },
        {
            id: '113',
            title: 'Enjoy Life',
            author: 'Jasmine',
            content: 'Content of the Post 3 Enjoy Life'

        }
    ])
    const [title, setTitle] = useState('')
    const [clickedItem, setClickedItem] = useState({})

    const changeName = () => {
        let newList = [...posts]
        newList[0].title = title
        setPosts(newList)
    }
    const handleClickedItem = (id) => {
        let postObj = posts.find(s => s.id == id)
        setClickedItem(postObj)
    }

    return (
        <div>
            <Posts list={posts} clickedItem={(id) => handleClickedItem(id)} />

            <div className='post-changeName'>

                <input type="text" value={title} onChange={e => setTitle(e.target.value)} />

                <button onClick={changeName}>Change Name</button>

            </div>


            {
                Object.keys(clickedItem).length != 0 &&
                <PostDetail post={clickedItem} />
            }


        </div>
    )
}
