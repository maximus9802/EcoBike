import axios from 'axios'
import { useEffect, useState } from 'react';

const BikeInfo = () => {    
    const id = 1;
    const [bike, setBike] = useState({});
    useEffect(() =>{
        const bikeInfoUrl = `http://localhost:6868/api/bikes/${id}`
        const bikeTrackerUrl = `http://localhost:6868/api/tracker/${id}`
        axios.get(bikeInfoUrl).then((response) => {
            console.log(response);
            setBike(response.data);
        }).catch((error) => {
            console.error(error);
        })
        axios.get(bikeTrackerUrl).then((response) => {
            console.log(response);
        })
    }, [])

    if (bike === {}) 
        return <div></div>
    else return(
        <div className="w-1/3">
            <div className='bg-green-500 p-2 rounded'>
                <h1 className='text-xl font-semibold'>Your renting bike</h1>
                <div className='grid grid-cols-2 text-sm font-semibold'>
                    <div>Type</div>
                    <div className=''>{bike.type}</div>
                    <div>License plate</div>
                    <div className=''>{bike.licensePlate}</div>
                    <div>Deposit</div>
                    <div className=''>{bike.deposit}đ</div>
                    <div>Type</div>
                    <div className=''>{bike.type}</div>
                    <div>Type</div>
                    <div className=''>{bike.type}</div>
                    <div>Type</div>
                    <div className=''>{bike.type}</div>
                    <div>Type</div>
                    <div className=''>{bike.type}</div>
                    <div>Type</div>
                    <div className=''>{bike.type}</div>

                </div>
            </div>
            
        </div>
    )
}

export default BikeInfo;