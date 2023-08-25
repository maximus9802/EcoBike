
import { useState } from "react"
import BikeIn from "../../components/BikeIn"
import "primereact/resources/themes/lara-light-indigo/theme.css"; // theme
import "primereact/resources/primereact.css"; // core css
import "primeicons/primeicons.css"; // icons


const EachBike = ({ data }) => {
    const [visible, setVisible] = useState(false)
    // console.log(data.id)
    return (
        <div>
            <BikeIn
                visible={visible}
                onHide={() => setVisible(false)}
                id={data.id} />
            <div className="grid grid-cols-8 gap-4 my-3 bg-slate-300 mx-3 rounded-lg"
            onClick={() =>setVisible(true)}
            >

                <div className="col-span-3">
                    {data.type == "Standard bike" &&
                        <img
                            className="w-full h-full rounded-l-lg" src="https://media.istockphoto.com/id/1176169958/photo/group-of-cyclist-at-professional-race.jpg?b=1&s=170667a&w=0&k=20&c=dNdVN97RdAT5YaSP5gzsujl0I8xj6SeqooX--6TiDDM=" />}
                    {data.type == "E-bike" &&
                        <img
                            className="w-full h-full rounded-l-lg" src="https://media.istockphoto.com/id/1415313700/photo/e-bike-battery-in-the-heat-of-the-sun.jpg?b=1&s=170667a&w=0&k=20&c=4k8pZwjla6otskl1GJEHEqdvBNPd47I_ap5XDiIDUAQ=" />}
                    {data.type == "Twin bike" &&
                        <img
                            className="w-full h-full rounded-l-lg" src="https://media.istockphoto.com/id/1339203317/photo/wedding-vintage-old-retro-tandem-bike-with-together-forever-just-married-sign-and-fresh.jpg?b=1&s=170667a&w=0&k=20&c=35ZqWH82bOB6UljlJZnaZRCmuaUCwWjkL1YqlRP-_00=" />}
                </div>
                <div className="col-span-5">
                    <div className="my-2"><span className="text-violet-800 me-2 text-xl font-semibold">Type:</span><span className="text-purple-950 font-bold text-xl">{data.type}</span></div>
                    <div><span className="text-violet-800 me-2 text-xl font-semibold">Price:</span><span className="text-xl font-semibold">{data.price}</span></div>
                    {
                        data.battery != null ? (
                            <div><span className="text-violet-800 me-2 text-xl font-semibold">Battery:</span><span className=" text-xl font-bold text-green-700">{data.battery}%</span></div>
                        ) : (
                            <>
                            </>
                        )
                    }
                    <div>
                        <span className="text-violet-800 me-2 text-xl font-semibold">
                            Plate:
                        </span>
                        <span className="text-2xl font-bold">{data.licensePlate}</span>
                    </div>
                </div>
            </div>
        </div>
    )
}
export default EachBike