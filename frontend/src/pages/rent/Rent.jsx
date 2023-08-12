// import { useState } from 'react';
// import { useParams } from 'react-router-dom'; // Make sure you have react-router-dom installed
import { useNavigate } from "react-router-dom";

const Rent = () => {
    // const { bikeId } = useParams(); 
    const navigate = useNavigate();

    // State to store rental details
    // const [rentalDetails, setRentalDetails] = useState({
    //     bikeId: bikeId,
    //     rentDuration: 0,
    // });

    // Function to handle form submission
    const handleRent = (e) => {
        e.preventDefault();
        console.log("Rented!");
    };

    const handleCancel = () => {
        navigate("/");
    }

    // Function to update rental details
    // const handleInputChange = (e) => {
    //     const { name, value } = e.target;
    //     setRentalDetails({
    //     ...rentalDetails,
    //     [name]: value,
    //     });
    // };

    // const handleConfirm = (e) => {
    //     e.preventDefault();
    //     console.log("Confirmed!");
    // };

    return (
        <div className="p-4">
            <h1 className="text-center text-3xl">TRANSACTION INFORMATION</h1>
            <form onSubmit={handleRent} className="mt-4 ">
                <div className="flex ">
                    <div className="w-2/12"></div>
                    <div className="w-4/12">
                        <div className="m-4 flex">
                            <label className="block font-semibold mb-1">Bike ID: </label>
                            {" "}
                            <div className="ml-4">
                                123213
                            </div>
                        </div>

                        <div className="m-4 flex ">
                            <label className="block font-semibold mb-1">Bike Image: </label>
                            {" "}
                            <div className="ml-4">
                                XYZ
                            </div>
                        </div>

                        <div className="m-4 flex ">
                            <label className="block font-semibold mb-1">License plate: </label>
                            {" "}
                            <div className="ml-4">
                                JP-202012
                            </div>
                        </div>

                        <div className="m-4 flex ">
                            <label className="block font-semibold mb-1">Bike Type: </label>
                            {" "}
                            <div className="ml-4">
                                E-bike
                            </div>
                        </div>

                        <div className="m-4 flex ">
                            <label className="block font-semibold mb-1">Rental price: </label>
                            {" "}
                            <div className="ml-4">
                                {new Intl.NumberFormat().format(20000)}
                                {" "}
                                VND/hour
                            </div>
                        </div>

                        <div className="m-4 flex ">
                            <label className="block font-semibold mb-1">Deposit: </label>
                            {" "}
                            <div className="ml-4">
                                {new Intl.NumberFormat().format(400000)}
                                {" "}
                                VND
                            </div>
                        </div>

                        <div className="m-4 flex ">
                            <label className="block font-semibold mb-1">Status: </label>
                            {" "}
                            <div className="ml-4">
                                Free
                            </div>
                        </div>
                    </div>

                    <div className="w-1/12"></div>

                    <div className="w-2/6">
                        <div className="m-4 flex">
                            <label className="block font-semibold mb-1">Card holder name: </label>
                            {" "}
                            <div className="ml-4">
                                VU HONG QUANG
                            </div>
                        </div>

                        <div className="m-4 flex">
                            <label className="block font-semibold mb-1">Expired date: </label>
                            {" "}
                            <div className="ml-4">
                                10/27
                            </div>
                        </div>

                        <div className="m-4 flex ">
                            <label className="block font-semibold mb-1">Card number: </label>
                            {" "}
                            <div className="ml-4">
                                1234 1232 4343 2133
                            </div>
                        </div>

                        <div className="m-4 flex ">
                            <label className="block font-semibold mb-1">Issuing bank: </label>
                            {" "}
                            <div className="ml-4">
                                ViettinBank
                            </div>
                        </div>

                        <div className="m-4 flex ">
                            <label className="block font-semibold mb-1">Balance: </label>
                            {" "}
                            <div className="ml-4">
                                {new Intl.NumberFormat().format(9999999)}
                            </div>
                        </div>
                    </div>
                </div>

                <div className="flex justify-center">
                <button 
                        type="submit" 
                        className="bg-blue-500 text-white px-4 py-2 rounded m-2"
                        // onClick= {handleRent}
                    >
                        Confirm
                    </button>
                    {"  "}
                    <button 
                        type="submit" 
                        className="bg-red-500 text-white px-4 py-2 rounded m-2"
                        onClick= {handleCancel}
                    >
                        Cancel
                    </button>
                </div>
            </form>

        </div>
    );
};

export default Rent;
