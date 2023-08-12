// import { useEffect } from "react";
import { Link } from "react-router-dom";
// import route from "../constants/route";

const MenuBar = () => {
  return (
    <nav className="bg-blue-400 p-4 flex justify-between items-center">
      <Link to="/" className="text-white text-xl font-semibold">EcoBikeRental</Link>
      <div className="flex">
        <input
          type="text"
          placeholder="Search..."
          className="border rounded px-2 py-1 mr-2"
        />
        {/* <Link to="/rentals" className="text-white">Rentals</Link> */}
        <Link to="/dockingpoint" className="text-white ml-4">Bikes</Link>
        <Link to="/dock" className="text-white ml-4">Docks</Link>
        {/* Add more navigation links */}
      </div>
    </nav>
  );
};

export default MenuBar;
