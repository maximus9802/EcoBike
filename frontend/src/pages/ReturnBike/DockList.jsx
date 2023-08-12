import { useEffect, useReducer, useState } from "react"
import DockItem from "./DockItem"
import axios from "axios"
const DockList = () => {
    const [dockList, setDockList] = useState([])
    useEffect(() => {
        const url = "http://localhost:6868/api/docks"
        axios.get(url).then((response) => {
            console.log(response)
            setDockList(response.data)
        }).catch((error) => {
            console.error(error)
        })
    }, [])
    if(dockList.length == 0)
        return(
            <div></div>
        )
    else return(
        <div className="bg-red-500 w-2/3 p-2">
            <h1 className="text-xl font-bold">Select a dock to return your bike</h1>
            <div className="">
                {dockList.map((dock) => (
                    <DockItem key={dock.id} item={dock}/>
                ))}
            </div>

        </div>
    )
}

export default DockList;