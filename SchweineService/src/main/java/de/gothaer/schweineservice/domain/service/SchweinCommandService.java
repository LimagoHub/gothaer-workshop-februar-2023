package de.gothaer.schweineservice.domain.service;


import de.gothaer.schweineservice.domain.aggregate.Schwein;

public interface SchweinCommandService {

   void speichern(Schwein schwein) throws SchweineServiceException;
   void aendern(Schwein schwein) throws SchweineServiceException;

   boolean loeschen(String id) throws SchweineServiceException;

   boolean futtern(String id) throws SchweineServiceException;
}
