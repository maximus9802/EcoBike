import { Link } from 'react-router-dom'; // Đảm bảo bạn đã cài đặt react-router-dom

const SideBar = () => {
  return (
    <div className="sidebar">
      <h2>EcoBikeRental</h2>
      <ul>
        <li>
          <Link to="/">Home page</Link>
        </li>
        <li>
          <Link to="/bikes">Bikes</Link>
        </li>
        <li>
          <Link to="/docks">Docks</Link>
        </li>
        {/* Thêm các liên kết khác tại đây */}
      </ul>
    </div>
  );
};

export default SideBar;
