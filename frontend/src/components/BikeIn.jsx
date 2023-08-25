import { useState, useEffect } from "react"
import { Button } from 'primereact/button';
import { Dialog } from 'primereact/dialog';
import axios from "axios";

const BikeIn = ({ id, visible, onHide }) => {
    const [bike, getBike] = useState({})
    useEffect(() => {
        const fetchData = async () => {
            try {
                const res = await axios.get(`http://localhost:6868/api/bikes/${id}`)
                console.log(res.data)
                getBike(res.data)
            } catch (err) {
                console.log("error to fetch data listDock: ", err)
            }
        }
        fetchData()
    }, [])

    if (!bike) {
        return (
            <div>
                Loading...
            </div>
        )
    }
    return (
        <Dialog
            visible={visible}
            closable={false}
            header="Bike Information"
            footer={
                <div>
                    <Button label="Ok" onClick={onHide} className="p-button-secondary" />

                </div>
            }
        >
            <div className="my-2"><span className="text-violet-800 me-2 text-xl font-semibold">Type:</span><span className="text-purple-950 font-bold text-xl">{bike.type}</span></div>
            <div><span className="text-violet-800 me-2 text-xl font-semibold">Price:</span><span className="text-xl font-semibold">{bike.price}</span></div>
            {
                bike.battery != null ? (
                    <div><span className="text-violet-800 me-2 text-xl font-semibold">Battery:</span><span className=" text-xl font-bold text-green-700">{bike.battery}%</span></div>
                ) : (
                    <>
                    </>
                )
            }
            <div><span className="text-violet-800 me-2 text-xl font-semibold">Description:</span>{bike.description}</div>

            <div>
                <span className="text-violet-800 me-2 text-xl font-semibold">
                    Plate:
                </span>
                <span className="text-2xl font-bold">{bike.licensePlate}</span>
            </div>

            <div><span className="text-violet-800 me-2 text-xl font-semibold">Deposit:</span><span className="text-xl font-semibold">{bike.deposit}</span></div>
        </Dialog>
    )
}
export default BikeIn