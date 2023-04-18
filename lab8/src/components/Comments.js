import axios from 'axios'
import React, { useState, useEffect } from 'react'

export default function Comments({ postId }) {
    const [comments, setComments] = useState([])

    const fetchComments = () => {
        axios.get(`http://localhost:8080/api/v1/comments/post/${postId}`)
            .then(res => {
                setComments(res.data)
                console.log(res.data)
            }).catch(err => {
                console.log(err)
            })
    }
    useEffect(() => {
        fetchComments()
    }, [postId])

    return (

        <ul className="list-group list-group-flush">
            {
                comments.map(c =>
                    <li class="list-group-item" key={c.id}>
                        {c.name}
                    </li>
                )
            }
        </ul>

    )
}
