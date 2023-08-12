import { RouterProvider } from "react-router-dom";
import router from "./router";
// import SideBar from './components/SideBar';

function App() {

  return (
    <>
      <RouterProvider router={router} />
    </>
  )
}

export default App
