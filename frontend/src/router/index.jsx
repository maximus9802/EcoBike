import { createBrowserRouter } from "react-router-dom";
import route from "../constants/route";
import DefaultLayout from "../components/DefaultLayout";
import Home from "../pages/home/Home";
import ReturnBikePage from "../pages/ReturnBike/ReturnBikePage";
import Rent from "../pages/rent/Rent";
import CardRent from "../pages/card-rent/CardRent";
import DockingPoint from "../pages/dockingpoint/DockingPoint";
import Dock from "../pages/dock/Dock";
import CardReturn from "../pages/card-return/CardReturn";
import TransactionReturn from "../pages/transaction-return/TransactionReturn";

const router = createBrowserRouter([
    {
        path: "/",
        element: <DefaultLayout />,
        children: [
            {
                path: route.HOME,
                element: <Home/>,
            },
            {
                path: route.DOCK,
                element: <Dock/>,
            },
            {
                path: route.DOCKINGPOINT,
                element: <DockingPoint/>,
            },
            {
                path: route.RETURN_BIKE,
                element: <ReturnBikePage/>,
            },
            {
                path: route.CARD_RETURN,
                element: <CardReturn />,
            },
            {
                path: route.TRANSACTION_RETURN,
                element: <TransactionReturn />,
            },
            {
                path: route.RENT,
                element: <Rent />,
            },
            {
                path: route.CARD_RENT,
                element: <CardRent />,
            },
        ],
    },
]);

export default router;