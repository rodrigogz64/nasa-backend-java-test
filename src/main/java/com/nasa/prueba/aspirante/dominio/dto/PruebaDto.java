package com.nasa.prueba.aspirante.dominio.dto;

import java.util.List;

public class PruebaDto {
    private Collection collection;

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public static class Collection {
        private String version;
        private String href;
        private List<Item> items;
        private Metadata metadata;

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public List<Item> getItems() {
            return items;
        }

        public void setItems(List<Item> items) {
            this.items = items;
        }

        public Metadata getMetadata() {
            return metadata;
        }

        public void setMetadata(Metadata metadata) {
            this.metadata = metadata;
        }
    }

    public static class Item {
        private String href;
        private List<Data> data;
        private List<Link> links;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public List<Data> getData() {
            return data;
        }

        public void setData(List<Data> data) {
            this.data = data;
        }

        public List<Link> getLinks() {
            return links;
        }

        public void setLinks(List<Link> links) {
            this.links = links;
        }
    }

    public static class Data {
        private String center;
        private String title;
        private List<String> keywords;
        private String nasa_id;
        private String date_created;
        private String media_type;
        private String description;

        public String getCenter() {
            return center;
        }

        public void setCenter(String center) {
            this.center = center;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getKeywords() {
            return keywords;
        }

        public void setKeywords(List<String> keywords) {
            this.keywords = keywords;
        }

        public String getNasa_id() {
            return nasa_id;
        }

        public void setNasa_id(String nasa_id) {
            this.nasa_id = nasa_id;
        }

        public String getDate_created() {
            return date_created;
        }

        public void setDate_created(String date_created) {
            this.date_created = date_created;
        }

        public String getMedia_type() {
            return media_type;
        }

        public void setMedia_type(String media_type) {
            this.media_type = media_type;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    public static class Link {
        private String href;
        private String rel;
        private String render;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public String getRel() {
            return rel;
        }

        public void setRel(String rel) {
            this.rel = rel;
        }

        public String getRender() {
            return render;
        }

        public void setRender(String render) {
            this.render = render;
        }
    }

    public static class Metadata {
        private int total_hits;

        public int getTotal_hits() {
            return total_hits;
        }

        public void setTotal_hits(int total_hits) {
            this.total_hits = total_hits;
        }
    }
}