/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.List;

@JsonSerialize(using=GetMetadataArgs.Serializer.class)
@JsonDeserialize(using=GetMetadataArgs.Deserializer.class)
class GetMetadataArgs {
    // struct GetMetadataArgs

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String sharedFolderId;
    protected final List<FolderAction> actions;

    /**
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param actions  Folder actions to query. Must not contain a {@code null}
     *     item.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetMetadataArgs(String sharedFolderId, List<FolderAction> actions) {
        if (sharedFolderId == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
        }
        if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
            throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
        }
        this.sharedFolderId = sharedFolderId;
        if (actions != null) {
            for (FolderAction x : actions) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'actions' is null");
                }
            }
        }
        this.actions = actions;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetMetadataArgs(String sharedFolderId) {
        this(sharedFolderId, null);
    }

    /**
     * The ID for the shared folder.
     *
     * @return value for this field, never {@code null}.
     */
    public String getSharedFolderId() {
        return sharedFolderId;
    }

    /**
     * Folder actions to query.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public List<FolderAction> getActions() {
        return actions;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            sharedFolderId,
            actions
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            GetMetadataArgs other = (GetMetadataArgs) obj;
            return ((this.sharedFolderId == other.sharedFolderId) || (this.sharedFolderId.equals(other.sharedFolderId)))
                && ((this.actions == other.actions) || (this.actions != null && this.actions.equals(other.actions)))
                ;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return serialize(false);
    }

    /**
     * Returns a String representation of this object formatted for easier
     * readability.
     *
     * <p> The returned String may contain newlines. </p>
     *
     * @return Formatted, multiline String representation of this object
     */
    public String toStringMultiline() {
        return serialize(true);
    }

    private String serialize(boolean longForm) {
        try {
            return JsonUtil.getMapper(longForm).writeValueAsString(this);
        }
        catch (JsonProcessingException ex) {
            throw new RuntimeException("Failed to serialize object", ex);
        }
    }

    static final class Serializer extends StructJsonSerializer<GetMetadataArgs> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GetMetadataArgs.class);
        }

        public Serializer(boolean unwrapping) {
            super(GetMetadataArgs.class, unwrapping);
        }

        @Override
        protected JsonSerializer<GetMetadataArgs> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(GetMetadataArgs value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("shared_folder_id", value.sharedFolderId);
            if (value.actions != null) {
                g.writeObjectField("actions", value.actions);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<GetMetadataArgs> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GetMetadataArgs.class);
        }

        public Deserializer(boolean unwrapping) {
            super(GetMetadataArgs.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<GetMetadataArgs> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public GetMetadataArgs deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String sharedFolderId = null;
            List<FolderAction> actions = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("shared_folder_id".equals(_field)) {
                    sharedFolderId = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("actions".equals(_field)) {
                    expectArrayStart(_p);
                    actions = new java.util.ArrayList<FolderAction>();
                    while (!isArrayEnd(_p)) {
                        FolderAction _x = null;
                        _x = _p.readValueAs(FolderAction.class);
                        _p.nextToken();
                        actions.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (sharedFolderId == null) {
                throw new JsonParseException(_p, "Required field \"shared_folder_id\" is missing.");
            }

            return new GetMetadataArgs(sharedFolderId, actions);
        }
    }
}
