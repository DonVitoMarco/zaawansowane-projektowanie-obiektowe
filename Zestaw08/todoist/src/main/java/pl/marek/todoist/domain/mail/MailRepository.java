package pl.marek.todoist.domain.mail;

import org.springframework.data.mongodb.repository.MongoRepository;

interface MailRepository extends MongoRepository<Mail, String>, CustomMailRepository {
}
