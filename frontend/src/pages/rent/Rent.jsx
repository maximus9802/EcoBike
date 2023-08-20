import { useState, useEffect } from 'react';
// import { useParams } from 'react-router-dom'; // Make sure you have react-router-dom installed
import { useLocation, useNavigate } from "react-router-dom";
import axios from 'axios';
import { ToastContainer,toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const Rent = () => {
    // const { bikeId } = useParams(); 
    const location = useLocation();
    const [bike, setBike] = useState({});
    const [transactionContent, setTransactionContent] = useState("");
    const [balance, setBalance] = useState('');
    // const [createdAt, setCreatedAt] = useState(null);
    
    const navigate = useNavigate();
    const id = 3;

    const getBikeInfo = () => {
        const bikeInfoUrl = `http://localhost:6868/api/bikes/${id}`
        axios.get(bikeInfoUrl).then((response) => {
            setBike(response.data);
        }).catch((error) => {
            toast.error(error, {
                position: toast.POSITION.TOP_RIGHT
            });
            console.error(error);
        })
    };

    useEffect(() =>{
        getBalance();
        getBikeInfo();
    },[]);

    const handleProcessTransaction = async () => {
        try {
            if (transactionContent.trim() === "") {
                toast.error('Transaction content cannot be empty!', {
                    position: toast.POSITION.TOP_RIGHT
                });
                return;
            }
            
            if(balance < bike.deposit) {
                toast.error('Not enough balance!', {
                    position: toast.POSITION.TOP_RIGHT
                });
                return;
            }

            const transactionDto = {
                cardCode: location.state.cardCode ,
                owner: location.state.cardHolderName,
                cvvCode: location.state.cvvCode,
                dateExpired: location.state.dateExpired,
                command: "pay",
                transactionContent,
                amount: bike.deposit,
                createdAt: new Date().toISOString().slice(0, 19),
            };

            await axios.put('http://localhost:6868/api/card/processTransaction', transactionDto);
            toast.success('Successful transaction!', {
                position: toast.POSITION.TOP_RIGHT
            });
            navigate("/");
            alert("Successful transaction!");
        } catch (error) {
            toast.error(error, {
                position: toast.POSITION.TOP_RIGHT
            });
            console.log(error);
        }
    };

    const getBalance = async () => {
        try {
            const response = await axios.get(`http://localhost:6868/api/card/get-balance/${location.state.cardCode}`);
            setBalance(response.data.balance);
        } catch (error) {
            toast.error(error, {
                position: toast.POSITION.TOP_RIGHT
            });
            console.error(error);
        }
    };

    // Function to handle form submission
    const handleRent = (e) => {
        e.preventDefault();
    };

    const handleCancel = () => {
        navigate("/");
        toast.error("Rent bike failed!", {
            position: toast.POSITION.TOP_RIGHT
        });
    };

    return (
        <div className="p-4">
            <ToastContainer />
            <h1 className="text-center text-3xl">TRANSACTION INFORMATION</h1>
            <form onSubmit={handleRent} className="mt-4 ">
                <div className="flex ">
                    <div className="w-2/12"></div>
                    <div className="w-4/12">
                        <div className="m-4 flex">
                            <label className="block font-semibold mb-1">Bike ID: </label>
                            {" "}
                            <div className="ml-4">
                                {bike.id}
                            </div>
                        </div>

                        <div className="m-4 flex ">
                            <label className="block font-semibold mb-1">License plate: </label>
                            {" "}
                            <div className="ml-4">
                                {bike.licensePlate}
                            </div>
                        </div>

                        <div className="m-4 flex ">
                            <label className="block font-semibold mb-1">Bike Type: </label>
                            {" "}
                            <div className="ml-4">
                                {bike.type}
                            </div>
                        </div>

                        {bike.battery && 
                            <div className="m-4 flex ">
                                <label className="block font-semibold mb-1">Battery: </label>
                                {" "}
                                <div className="ml-4">
                                    {bike.battery}
                                    {" "}
                                    %
                                </div>
                            </div>
                        }

                        <div className="m-4 flex ">
                            <label className="block font-semibold mb-1">Rental price: </label>
                            {" "}
                            <div className="ml-4">
                                {new Intl.NumberFormat().format(`${bike.price}`)}
                                {" "}
                                VND/hour
                            </div>
                        </div>

                        <div className="m-4 flex ">
                            <label className="block font-semibold mb-1">Deposit: </label>
                            {" "}
                            <div className="ml-4">
                                {new Intl.NumberFormat().format(`${bike.deposit}`)}
                                {" "}
                                VND
                            </div>
                        </div>
                    </div>

                    <div className="w-1/12"></div>

                    <div className="w-2/6">
                        <div className="m-4 flex">
                            <label className="block font-semibold mb-1">Card holder name: </label>
                            {" "}
                            <div className="ml-4">
                                {location.state.cardHolderName}
                            </div>
                        </div>

                        <div className="m-4 flex ">
                            <label className="block font-semibold mb-1">Cvv code: </label>
                            {" "}
                            <div className="ml-4">
                                {location.state.cvvCode}
                            </div>
                        </div>

                        <div className="m-4 flex ">
                            <label className="block font-semibold mb-1">Card code: </label>
                            {" "}
                            <div className="ml-4">
                                {location.state.cardCode}
                            </div>
                        </div>

                        <div className="m-4 flex ">
                            <label className="block font-semibold mb-1">Balance: </label>
                            {" "}
                            {balance && 
                                <div className="ml-4">
                                    {new Intl.NumberFormat().format(balance)}
                                </div>
                            } 
                        </div>

                        <div className="m-4 flex ">
                            <label className="block font-semibold mb-1">Amount: </label>
                            {" "}
                            <div className="ml-4">
                            {new Intl.NumberFormat().format(`${bike.deposit}`)}
                            </div>
                        </div>

                        <div className="m-4 flex ">
                            <label className="block font-semibold mb-1">Transaction content </label>
                            {" "}
                            <input
                                type="text"
                                className="border rounded px-2 py-2 w-4/5 mb-2"
                                onChange={(e) => setTransactionContent(e.target.value)}
                            />
                        </div>



                    </div>
                </div>

                <div className="flex justify-center">
                    <button 
                        onClick={handleProcessTransaction}
                        className="bg-blue-500 hover:bg-blue-700 text-white px-4 py-2 rounded-full m-2"
                    >
                        Confirm
                    </button>
                    {" "}
                    <button 
                        type="submit" 
                        className="bg-blue-500 hover:bg-blue-700 text-white px-4 py-2 rounded-full m-2 hidden"
                        onClick= {handleRent}
                    >
                        Confirm
                    </button>
                    {"  "}
                    <button 
                        type="submit" 
                        className="bg-red-500 hover:bg-red-700 text-white px-4 py-2 rounded-full m-2"
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
