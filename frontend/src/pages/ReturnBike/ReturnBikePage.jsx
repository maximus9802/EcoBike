import DockList from "./DockList"
import BikeInfo from "./BikeInfo"

const ReturnBikePage = () => {
    return(
        <div className="flex gap-4 p-4">
            <DockList />
            <BikeInfo />
        </div>
    );
}

export default ReturnBikePage;

