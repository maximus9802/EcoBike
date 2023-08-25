import { useState, useEffect } from "react";
import axios from 'axios';
import EachDock from "../../components/EachDock";

const Home = () => {
  const [listDock, setListDock] = useState([])

  useEffect(()=>{
    const fetchData = async() =>{
      try{
        const res = await axios.get('http://localhost:6868/api/docks')
        // console.log(res.data)
        setListDock(res.data)
      }catch(err){
        console.log("error to fetch data listDock: ", err)
      }
    }
    fetchData()
  },[])
  if(!listDock){
    return(
      <div>
        Loading...
      </div>
    )
  }

  return (
    <div>
      <div className="text-center text-5xl font-bold">All Docks</div>
      {listDock.map((eachDock, index)=>(
        <EachDock key={index} data = {eachDock}/>
      ))}
    </div>
  );
};

export default Home;
