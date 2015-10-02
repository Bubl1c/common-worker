package workerapp.entity;

/**
 * Created by Andrii Mozharovskyi on 30.09.2015.
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Record {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Type type;
    private Date date;
    private String ip;
    private String email;
    private String webSite;
    private String originationServer;
    private String uidlRef;

    public enum Type {
        HACKING, STALKING, MALICIOUS_SOFT
    }

    public Record() {
    }

    public Record(Type type, Date date, String ip, String email, String webSite, String originationServer, String uidlRef) {
        this.type = type;
        this.date = date;
        this.ip = ip;
        this.email = email;
        this.webSite = webSite;
        this.originationServer = originationServer;
        this.uidlRef = uidlRef;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getOriginationServer() {
        return originationServer;
    }

    public void setOriginationServer(String originationServer) {
        this.originationServer = originationServer;
    }

    public String getUidlRef() {
        return uidlRef;
    }

    public void setUidlRef(String uidlRef) {
        this.uidlRef = uidlRef;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", taskType=" + type +
                ", date=" + date +
                ", ip='" + ip + '\'' +
                ", email='" + email + '\'' +
                ", webSite='" + webSite + '\'' +
                ", originationServer='" + originationServer + '\'' +
                ", uidlRef='" + uidlRef + '\'' +
                '}';
    }
}
