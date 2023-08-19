import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faLocationDot } from '@fortawesome/free-solid-svg-icons';
const DockItem = (props) => {
    const handleClick = () => {
        console.log("click")
    }
    // console.log(item)
    // console.log(props.item)
    return(
        <div className='font-semibold p-2 bg-yellow-300 hover:bg-yellow-100 hover:cursor-pointer' onClick={handleClick}>
            <div>{props.item.name}</div>
            <div className="text-sm italic">
            <FontAwesomeIcon icon={faLocationDot} />
                <span> {props.item.location}</span>
            </div>
        </div>
    )
}

export default DockItem;