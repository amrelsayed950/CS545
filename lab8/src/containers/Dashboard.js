import React,{useState} from 'react'
import PostDetail from '../components/PostDetail'
import Posts from '../components/Posts'
import AddPost from '../components/AddPost'

export default function Dashboard() {
    
    const [fetchFlag, setFetchflag] = useState(true);    
    const [clickedItemId, setClickedItemId] = useState(0)
 
    
    const handleClickedItem = (id) =>{
        setClickedItemId(id)        
    }

    const changeFetchFlag = () =>{
       setFetchflag(!fetchFlag)
    }

  return (
    <div>        
        <Posts clickedItem = {handleClickedItem} fetchFlag={fetchFlag}/>        
        <AddPost changeFetchFlag={changeFetchFlag} />
        {
            clickedItemId !== 0  &&
            <PostDetail postId={clickedItemId}  changeFetchFlag={changeFetchFlag}  />
        }
        
        
    </div>
  )
}
