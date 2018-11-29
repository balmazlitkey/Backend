package balmaz.saildatamanager.backend.backend.data;

import com.google.gson.annotations.Expose;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;

@Document(collection = "tracks")
public class TrackingData {
	@Id
	@Expose(serialize = false)
	private ObjectId id;

	@Indexed
	private String instrumentId;

	private String startTime;

	private String endTime;

	private ArrayList<UserData> trackedUserData;

	@Override
	public String toString() {
		return "TrackingData{" +
				", instrumentId='" + instrumentId + '\'' +
				", startTime=" + startTime +
				", endTime=" + endTime +
				", trackedUserData=" + trackedUserData.toString() +
				'}';
	}

	public TrackingData(){

	}

	@PersistenceConstructor
	public TrackingData(ObjectId id, String startTime, String endTime, String instrumentId) {
		super();
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.instrumentId = instrumentId;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getInstrumentId() {
		return instrumentId;
	}

	public void setInstrumentId(String instrumentId) {
		this.instrumentId = instrumentId;
	}

	public void setTrackedUserData(ArrayList<UserData> trackedUserData){
		this.trackedUserData = trackedUserData;
	}

	public ArrayList<UserData> getUserData() {
		return trackedUserData;
	}

}
