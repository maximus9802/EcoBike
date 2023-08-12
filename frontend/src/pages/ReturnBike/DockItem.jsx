import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faLocationDot } from '@fortawesome/free-solid-svg-icons';
const DockItem = (props) => {
    const handleClick = () => {
        console.log("click")
    }
    return(
        <div className='font-semibold p-2 bg-yellow-300 hover:bg-yellow-100 hover:cursor-pointer' onClick={handleClick}>
            <div>Dock name</div>
            <div className="text-sm italic">
            <FontAwesomeIcon icon={faLocationDot} />
                <span> Dock location</span>
            </div>
        </div>
    )
}

export default DockItem;