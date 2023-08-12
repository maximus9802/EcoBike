import { createBrowserRouter } from "react-router-dom";
import route from "../constants/route";
import DefaultLayout from "../components/DefaultLayout";
import Home from "../pages/home/Home";
import ReturnBikePage from "../pages/ReturnBike/ReturnBikePage";
import RENT from "../pages/rent/Rent";
import CARD from "../pages/card/Card";
import DockingPoint from "../pages/dockingpoint/DockingPoint";
import Dock from "../pages/dock/Dock";

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
                path: route.RENT,
                element: <RENT />,
            },
            {
                path: route.CARD,
                element: <CARD />,
            },
        ],
    },
]);

export default router;