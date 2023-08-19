import { useState } from 'react';
// import { useParams } from 'react-router-dom'; // Make sure you have react-router-dom installed
import { useNavigate } from "react-router-dom";
import axios from 'axios';
import { ToastContainer,toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const CardReturn = () => {
    // const { bikeId } = useParams(); 
    // const [cardInfo, setCardInfo] = useState({});
    const [cardHolderName, setCardHolderName] = useState("");
    const [cvvCode, setCvvCode] = useState("");
    const [dateExpired, setDateExpired] = useState("");
    const [cardCode, setCardCode] = useState('');
    const navigate = useNavigate();

    let checkCardResult = false;

    const checkCard = async (e) => {
        e.preventDefault();
        
        try {
            if (
                cardHolderName.trim() === "" ||
                cvvCode.trim() === "" ||
                dateExpired.trim() === "" ||
                cardCode.trim() === ""
            ) {
                toast.error('Please fill in all fields!', {
                    position: toast.POSITION.TOP_RIGHT
                })
                return;
            }

            const response = await axios.get(`http://localhost:6868/api/card/check-card/${cardCode}`);
            checkCardResult = response.data.cardCode === cardCode;

            const confirmButton = document.querySelector('.confirm-button');
            const cancelButton = document.querySelector('.cancel-button');
            const confirmButtonSuccess = document.querySelector('.confirm-button-success');
    
            if (checkCardResult) {
                confirmButton.classList.remove('hidden');
                cancelButton.classList.remove('hidden');
                confirmButtonSuccess.classList.add('hidden');
                toast.success('Successfully found card!', {
                    position: toast.POSITION.TOP_RIGHT
                });
            } else {
                confirmButton.classList.add('hidden');
                cancelButton.classList.add('hidden');
                toast.error('No card found!', {
                    position: toast.POSITION.TOP_RIGHT
                });
            }
        } catch (error) {
            toast.error(error, {
                position: toast.POSITION.TOP_RIGHT
            });
            console.log(error);
        }
    }

    
    const handleConfirm = (e) => {
        e.preventDefault();
        try {
            
            if (checkCardResult === true) {
                navigate("/transaction-return",
                {   replace: true, 
                    state: {cardHolderName, cvvCode, dateExpired, cardCode}
                });
            }
        } catch (error) {
            toast.error(error, {
                position: toast.POSITION.TOP_RIGHT
            });
            console.log(error);
        }
    };

    const handleCancel = () => {
        navigate("/");
        toast.error("Choose credit card failed!", {
            position: toast.POSITION.TOP_RIGHT
        });
    }

    return (
        
        <div className="p-4">
            <ToastContainer />
            <h1 className="text-center text-3xl">CREDIT CARD</h1>
            <form onSubmit={handleConfirm} className="mt-4">
                <div className="flex justify-center">
                    <div className="w-1/3">
                        <label className="block font-semibold m-2">Card holder name</label>
                        <input
                            type="text"
                            required
                            className="border rounded px-2 py-2 w-full mb-2"
                            placeholder="Card holder name"
                            onChange={(e) => setCardHolderName(e.target.value)}
                        />
                    </div>
                </div>

                <div className="flex justify-center">
                    <div className="w-1/3">
                        <label className="block font-semibold m-2">Cvv Code</label>
                        <input
                            type="number"
                            required
                            className="border rounded px-2 py-2 w-full mb-2"
                            placeholder="Cvv code"
                            onChange={(e) => setCvvCode(e.target.value)} 
                        />
                    </div>
                </div>

                <div className="flex justify-center">
                    <div className="w-1/3">
                        <label className="block font-semibold m-2">Date Expired</label>
                        <input
                            type="number"
                            required
                            className="border rounded px-2 py-2 w-full mb-2"
                            placeholder="Date Expired"
                            onChange={(e) => setDateExpired(e.target.value)}   
                        />
                    </div>
                </div>

                <div className="flex justify-center">
                    <div className="w-1/3">
                        <label className="block font-semibold m-2">Card code</label>
                        <input
                            type="text"
                            required
                            className="border rounded px-2 py-2 w-full mb-2"
                            onChange={(e) => {setCardCode(e.target.value);}}
                            placeholder="Card Code"
                        />
                    </div>
                </div>

                <div className="flex justify-center m-4">
                    <button 
                        className="bg-blue-500 text-white px-4 py-2 rounded m-2 confirm-button-success"
                        onClick= {checkCard}
                    >
                        Check
                    </button>
                </div>

                <div className="flex justify-center m-4">
                    <button 
                        type="submit" 
                        className="bg-blue-500 text-white px-4 py-2 rounded m-2 hidden confirm-button"
                        onClick= {handleConfirm}
                    >
                        Choose
                    </button>
                    {"  "}
                    <button 
                        type="submit" 
                        className="bg-red-500 text-white px-4 py-2 rounded m-2 hidden cancel-button"
                        onClick= {handleCancel}
                    >
                        Cancel
                    </button>
                </div>
            </form>
        </div>
    );
};

export default CardReturn;
