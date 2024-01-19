package org.example.DAOImpl;

import org.example.DAO.InterfaceDAO;
import org.example.models.Note;

import java.util.List;

public class NoteDAOImpl implements InterfaceDAO<Note> {
    @Override
    public void create(Note element) {
        InterfaceDAO.super.create(element);
    }

    @Override
    public Note getById(long id) {
        return InterfaceDAO.super.getById(id);
    }

    @Override
    public void remove(long id) {
        InterfaceDAO.super.remove(id);
    }

    @Override
    public List<Note> getAll() {
        return InterfaceDAO.super.getAll();
    }

    @Override
    public Class<Note> getEntityClass() {
        return Note.class;
    }
}
