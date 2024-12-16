package Users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@XmlSeeAlso(FullAddress.class)
@XmlAccessorType(XmlAccessType.FIELD)
public class FullUser
{
    @XmlElement(name = "last")
    private String last;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "address")
    private FullAddress address;
    @XmlElement(name = "email")
    private String email;
    @XmlElement(name = "phone")
    private String phone;
    @XmlElement(name = "url")
    private String url;

    public static ArrayList<FullUser> getFullUsers(ArrayList<User> users) {
        return (ArrayList<FullUser>) users.stream()
                .map(user -> {
                    FullAddress fullAdress = new FullAddress(
                            user.getLocation().getCountry(),
                            user.getLocation().getState(),
                            user.getLocation().getCity(),
                            user.getLocation().getStreet().getName(),
                            user.getLocation().getStreet().getNumber()
                    );
                    return new FullUser(
                            user.getName().getLast(),
                            user.getName().getFirst(),
                            fullAdress,
                            user.getEmail(),
                            user.getPhone(),
                            user.getPicture().getLarge()
                    );
                })
                .collect(Collectors.toList());
    }

    public static FullResults getFullUsers(Results users) {
        FullResults results = new FullResults ((ArrayList<FullUser>) users.getUsers().stream()
                .map(user -> {
                    FullAddress fullAdress = new FullAddress(
                            user.getLocation().getCountry(),
                            user.getLocation().getState(),
                            user.getLocation().getCity(),
                            user.getLocation().getStreet().getName(),
                            user.getLocation().getStreet().getNumber()
                    );
                    return new FullUser(
                            user.getName().getLast(),
                            user.getName().getFirst(),
                            fullAdress,
                            user.getEmail(),
                            user.getPhone(),
                            user.getPicture().getLarge()
                    );
                })
                .collect(Collectors.toList()));
        return results;
    }
}
