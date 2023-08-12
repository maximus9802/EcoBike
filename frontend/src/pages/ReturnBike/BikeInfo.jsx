import axios from 'axios'
import { useEffect } from 'react';

const BikeInfo = () => {    
    const id = 1;
    useEffect(() =>{
        const url = `http://localhost:6868/api/bikes/${id}`
        axios.get(url).then((response) => {
            console.log(response);
        })
    }, [])

    return(
        <div className="bg-green-500 w-1/3 p-2">BikeInfo</div>
    )
}

export default BikeInfo;