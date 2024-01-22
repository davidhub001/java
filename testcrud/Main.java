import pack.*;

import java.util.List; // Ajoutez cette ligne pour importer la classe List

public class Main {
    public static void main(String[] args) {
        // Créer un client
        Client client = new Client(0, "Nom1", "Prenom1");
        Client.ClientDAO.createClient(client);

        // Lire tous les clients
        List<Client> clients = Client.ClientDAO.readAllClients();
        for (Client c : clients) {
            System.out.println("ID: " + c.getId() + ", Nom: " + c.getNom() + ", Prenom: " + c.getPrenom());
        }

        // // Mettre à jour un client
        // Client clientToUpdate = new Client(1, "NouveauNom", "NouveauPrenom");
        // Client.ClientDAO.updateClient(clientToUpdate);

        // // Lire à nouveau tous les clients après la mise à jour
        // clients = Client.ClientDAO.readAllClients();
        // for (Client c : clients) {
        //     System.out.println("ID: " + c.getId() + ", Nom: " + c.getNom() + ", Prenom: " + c.getPrenom());
        // }

        // // Supprimer un client
        // int clientIdToDelete = 1; // Remplacez par l'ID du client que vous souhaitez supprimer
        // Client.ClientDAO.deleteClient(clientIdToDelete);

        // // Lire à nouveau tous les clients après la suppression
        // clients = Client.ClientDAO.readAllClients();
        // for (Client c : clients) {
        //     System.out.println("ID: " + c.getId() + ", Nom: " + c.getNom() + ", Prenom: " + c.getPrenom());
        // }
    }
}
