package com.abc.backend.util;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.bson.types.ObjectId;

import com.abc.backend.model.DatabaseSequence;

@Component
public class SequenceIdGen {

    @Autowired
    private MongoOperations mongoOperations;

    /**
     * Generates the next sequence number for the given sequence name.
     * 
     * @param seqName the name of the sequence
     * @return the next sequence number
     */
    public long generateSequence(String seqName) {
        DatabaseSequence counter = mongoOperations.findAndModify(
            Query.query(Criteria.where("_id").is(seqName)),
            new Update().inc("seq", 1),
            options().returnNew(true).upsert(true),
            DatabaseSequence.class);

        return (counter != null) ? counter.getSeq() : 1;
    }

    /**
     * Converts a sequence number to an ObjectId.
     * 
     * @param sequence the sequence number
     * @return the corresponding ObjectId
     */
    public ObjectId createObjectIdFromSequence(long sequence) {
        // Convert the sequence to a hexadecimal string
        String hexString = Long.toHexString(sequence);
        // Ensure the string length is 24 (ObjectId length), padding with zeros if necessary
        while (hexString.length() < 24) {
            hexString = "0" + hexString;
        }
        // Create an ObjectId from the hexadecimal string
        return new ObjectId(hexString);
    }

    /**
     * Generates a new sequence number and creates an ObjectId from it.
     * 
     * @param seqName the name of the sequence
     * @return the generated ObjectId
     */
    public ObjectId generateAndCreateObjectId(String seqName) {
        long sequence = generateSequence(seqName);
        return createObjectIdFromSequence(sequence);
    }
}
