import axios from 'axios'
import React, { useState, useEffect } from 'react'
import Comments from './Comments'
import Comment from './Comments'

export default function PostDetail({ postId, changeFetchFlag }) {

    const [post, setPost] = useState({})

    const fetchPost = () => {
        axios.get(`http://localhost:8080/api/v1/posts/${postId}`)
            .then(res => {
                setPost(res.data)
                console.log(res.data)
            })
            .catch(err => {
                console.log(err)
            })
    }



    const deletePost = () => {
        axios.delete(`http://localhost:8080/api/v1/posts/${postId}`)
            .then(res => {
                changeFetchFlag()
                setPost({})
            }).catch(err => {
                console.log(err)
            })
    }



    const handleDelete = () => {
        deletePost()
    }

    

    useEffect(() => {
        fetchPost()
    }, [postId])

    return (
        <div >
            {
                Object.keys(post).length !== 0 &&

                <div className="post-detail">
                    <div className="card-body">
                        <h5 className="card-title">{post.title}</h5>
                        <h6 className="card-subtitle mb-2 text-muted">{post.author}</h6>
                        <p className="card-text">{post.content}</p>
                        <div className="card-header">Comments</div>
                        <Comments postId={postId} />
                        <div className='text-center'>
                            <a href="#" className="card-link">edit</a>
                            <a href="#" className="card-link" onClick={handleDelete}>delete</a>
                        </div>
                    </div>
                </div>
            }
        </div>
    )
}
