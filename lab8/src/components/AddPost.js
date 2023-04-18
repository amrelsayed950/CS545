import React, { useEffect, useState } from 'react'
import axios from 'axios'

export default function AddPost({ changeFetchFlag }) {
    const [post, setPost] = useState({
        title: '',
        author: '',
        content: '',
        userId: ''
    })
    
    const [validate, setValidate] = useState({})

    const addPost = () => {
        //hardcoded for now
        
        setPost({ ...post, 'userId': 1 })

        axios.post(`http://localhost:8080/api/v1/posts`, post)
            .then(res => {
                console.log(res)
                changeFetchFlag()
            })
            .catch(err => {
                console.log(err)
            })
    }

    const handleAddPost = () => {
        if(validateForm()){
            addPost();
        }
    }
    const handleOnChange = (e) => {        
       setPost({ ...post, [e.target.name]: e.target.value })
       
    }
    const handleReset = () =>{
        let cleanPost = {
            title: '',
            author: '',
            content: '',
            userId: ''
        }
        setPost(cleanPost)
    }

    const validateForm = () =>{
        let errors = {}
        if(post.title === ''){ 
            errors.title = 'Title is required.*';
        }
        if(post.author === ''){
            errors.author = 'Author is required.*';
        }
        if(post.content === ''){
            errors.content = 'Content is required.*';
        }
        setValidate(errors)

        if (Object.keys(errors).length === 0) {
            return true;
          } else {
            return false;
          }
    } 

    return (
        <div className="col-md-6 mb-3 ">
    
            <fieldset>
                    <legend>Add Post</legend>
            <div className="mb-3">
                <label  className="form-label">Title</label>
                <input required type="text" className="form-control" id="postTitle" placeholder="Enter post title" value={post.title} name={'title'} onChange={handleOnChange} />
                <div className="field-validate">{ validate.title}</div>
            </div>
            <div className="mb-3">
                <label  className="form-label">Author</label>
                <input required type="text" className="form-control" id="postAuthor" placeholder="Enter post title" value={post.author} name={'author'} onChange={handleOnChange} />
                <div className="field-validate">{ validate.author}</div>
            </div>
            <div className="mb-3">
                <label  className="form-label">Content</label>
                <textarea required className="form-control" id="postContent" rows="3" value={post.content} name={'content'} onChange={handleOnChange} ></textarea>
                <div className="field-validate">{validate.content}</div>
            </div>
            <div>
                <div className="col-auto">
                    <button className="btn btn-primary mb-3"  onClick={handleAddPost}>Add Post</button>
                    <button className="btn btn-submit mb-3"  onClick={handleReset}>Reset</button>
                </div>
            </div>
            </fieldset>
        </div>
    )
}
