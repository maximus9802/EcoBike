import { useState, useEffect } from "react";
import axios from 'axios';
import EachDock from "../../components/EachDock";

const Home = () => {
  const [listDock, setListDock] = useState([])

  useEffect(()=>{
    const fetchData = async() =>{
      try{
        const res = await axios.get('localhost:6868/api/docks')
        setListDock(res.data)
      }catch(err){
        console.log("error to fetch data listDock: ", err)
      }
    }
    fetchData()
  },[])
  if(!listDock)

  return (
    <div>
      {listDock.map((eachDock, index)=>(
        <EachDock key={index} data = {eachDock}/>
      ))}
    </div>
  );
};

export default Home;
