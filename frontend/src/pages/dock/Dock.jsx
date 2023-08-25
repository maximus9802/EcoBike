import { useState, useEffect } from "react";
import { useParams } from "react-router-dom"
import axios from "axios";
import EachBike from "./EachBike";



const Dock = () => {
  const [listBike, setListBike] = useState([])
  const { dockId } = useParams()

  useEffect(() => {
    const fetchData = async () => {
      try {
        const res = await axios.get(`http://localhost:6868/api/docks/${dockId}`)
        console.log(res.data.bikes)
        setListBike(res.data.bikes)
      } catch (err) {
        console.log("error to fetch data listDock: ", err)
      }
    }
    fetchData()
  }, [])

  if(!listBike)
  return(
    <div>
      Loading...
    </div>
  )

  return (
    <div>
      <div className="text-center text-5xl font-bold my-5">Dock {dockId}</div>
      

      {listBike.map((eachbike,index)=>(
        <EachBike key={index} data = {eachbike}/>
      ))}
    </div>
  );
};

export default Dock;
