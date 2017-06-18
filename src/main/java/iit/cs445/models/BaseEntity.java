package iit.cs445.models;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.persistence.*;
import java.util.Date;

@Configurable
@MappedSuperclass
public abstract class BaseEntity<ID> {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    @Transient
    LocalSessionFactoryBean localSessionFactoryBean;

    @Column(name = "creation_time", nullable = false)
    private Date creationTime;

    @Column(name = "modification_time", nullable = false)
    private Date modificationTime;

    @Version
    private long version;

    public abstract ID getId();

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(Date modificationTime) {
        this.modificationTime = modificationTime;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @PrePersist
    public void prePersist() {
        Date now = new Date();
        this.creationTime = now;
        this.modificationTime = now;
    }

    @PreUpdate
    public void preUpdate() {
        this.modificationTime = new Date();
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "creationTime=" + creationTime +
                ", modificationTime=" + modificationTime +
                ", version=" + version +
                '}';
    }

    public void saveNew(){
        Session session = localSessionFactoryBean.getObject().openSession();
        Transaction tx = session.beginTransaction();
        session.save(this);
        tx.commit();
        session.close();
    }

    public void update(){
        Session session = localSessionFactoryBean.getObject().openSession();
        Transaction tx = session.beginTransaction();
        session.update(this);
        tx.commit();
        session.close();
    }

    public void delete(){
        Session session = localSessionFactoryBean.getObject().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(this);
        tx.commit();
        session.close();
    }

}

