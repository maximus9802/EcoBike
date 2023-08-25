import axios from 'axios'
import { useEffect, useState } from 'react';

const BikeInfo = () => {    
    const id = 3;
    const [bike, setBike] = useState({});
    useEffect(() =>{
        const bikeInfoUrl = `http://localhost:6868/api/bikes/get-bike/${id}`
        const bikeTrackerUrl = `http://localhost:6868/api/tracker/${id}`
        axios.get(bikeInfoUrl).then((response) => {
            setBike(response.data);
        }).catch((error) => {
            console.error(error);
        })
        axios.get(bikeTrackerUrl).then((response) => {
            console.log("res2:",response);
        })
    }, [])

    return(
        <div className="w-1/3">
            <div className='bg-green-500 rounded'>
                <h1 className='text-xl font-semibold p-1'>Your renting bike</h1>
                <div className='grid grid-cols-2 text-sm font-semibold bg-green-300 p-1'>
                    <div>Type</div>
                    <div className=''>{bike.type}</div>
                    <div>License plate</div>
                    <div className=''>{bike.licensePlate}</div>
                    <div>Deposit</div>
                    <div className=''>{bike.deposit}đ</div>
                </div>
                <div className='flex text-sm font-semibold bg-green-300 p-2 justify-evenly'>
                    <button className='rounded-full bg-blue-400 hover:bg-blue-700 w-16 p-1'> Confirm</button>
                    <button className='rounded-full bg-red-400 hover:bg-red-700 w-16 p-1'>Quit</button> 
                </div>           
            </div>
        </div>
    )
}

export default BikeInfo;