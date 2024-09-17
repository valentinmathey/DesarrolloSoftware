package com.example.apirest.Config;

import com.example.apirest.Entity.Audit.Revision;
import org.hibernate.envers.RevisionListener;

public class CustomRevisionListener implements RevisionListener {
    public void newRevision(Object revisionEntity){ final Revision revision =(Revision) revisionEntity;}
}
