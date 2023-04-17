import React from 'react'

export default function PostDetail({post}) {
    return (
        <div className='post-detail'>
            <div><u>{post.title}</u></div>
            <div>{post.author}</div>
            <div>{post.content}</div>
            <a href="###">edit</a>&nbsp;&nbsp;<a href="###">delete</a>
        </div>
    )
}
