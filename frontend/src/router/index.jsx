import { createBrowserRouter } from "react-router-dom";
import route from "../constants/route";
import DefaultLayout from "../components/DefaultLayout";
import Home from "../pages/home/Home";
import BIKES from "../pages/bike/Bikes";
import DOCKS from "../pages/dock/Docks";

const router = createBrowserRouter([
    {
        path: "/",
        element: <DefaultLayout />,
        children: [
            {
                path: route.HOME,
                element: <Home />,
            },
            {
                path: route.BIKES,
                element: <BIKES />,
            },
            {
                path: route.DOCKS,
                element: <DOCKS />,
            },
        ],
    },
]);

export default router;