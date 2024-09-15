package unit.objectmothers;

import com.epam.dto.MetadataDto;
import com.epam.entity.Metadata;

public class ObjectMother {

    public static MetadataDto metadataDto(){
        return new MetadataDto("Tu principe", "Yankee Daddy", "Минусовки", "3:25", 0, "2000");
    }

    public static Metadata metadata(){
        return new Metadata(1, "Tu principe", "Yankee Daddy", "Минусовки", "3:25", 0, "2000");
    }

    public static Metadata metadataBeforeSave(){
        return new Metadata(null, "Tu principe", "Yankee Daddy", "Минусовки", "3:25", 0, "2000");
    }

}
