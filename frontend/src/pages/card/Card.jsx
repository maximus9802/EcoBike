// import { useState } from 'react';
// import { useParams } from 'react-router-dom'; // Make sure you have react-router-dom installed
import { useNavigate } from "react-router-dom";

const Card = () => {
    // const { bikeId } = useParams(); 
    const navigate = useNavigate();

    // Function to handle form submission
    const handleConfirm = (e) => {
        e.preventDefault();
        navigate("/rent");
        console.log("Rented!");
    };

    const handleCancel = () => {
        navigate("/");
    }

    // const handleConfirm = (e) => {
    //     e.preventDefault();
    //     console.log("Confirmed!");
    // };

    return (
        <div className="p-4">
            <h1 className="text-center text-3xl">CREDIT CARD</h1>
            <form onSubmit={handleConfirm} className="mt-4">
                <div className="flex justify-center">
                    <div className="w-1/3">
                        <label className="block font-semibold m-2">Cardholder name</label>
                        <input
                            type="text"
                            required
                            className="border rounded px-2 py-2 w-full mb-2"
                        />
                    </div>
                </div>

                <div className="flex justify-center">
                    <div className="w-1/3">
                        <label className="block font-semibold m-2">Card ID</label>
                        <input
                            type="text"
                            required
                            className="border rounded px-2 py-2 w-full mb-2"
                        />
                    </div>
                </div>

                <div className="flex justify-center">
                    <div className="w-1/3">
                        <label className="block font-semibold m-2">Security Code</label>
                        <input
                            type="text"
                            required
                            className="border rounded px-2 py-2 w-full mb-2"
                        />
                    </div>
                </div>

                <div className="flex justify-center">
                    <div className="w-1/3">
                        <label className="block font-semibold m-2">Issuing bank</label>
                        <input
                            type="text"
                            required
                            className="border rounded px-2 py-2 w-full mb-2"
                        />
                    </div>
                </div>


                <div className="flex justify-center m-4">
                    <button 
                        type="submit" 
                        className="bg-blue-500 text-white px-4 py-2 rounded m-2"
                        onClick= {handleConfirm}
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

export default Card;
