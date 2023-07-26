export default class Book {
    title
    description
    authorId

    constructor(title, description, authorId) {
        this.title = title
        this.description = description
        this.authorId = authorId
    }

    get title() {
        return this.title
    }

    get description() {
        return this.description
    }

    get authorId() {
        return this.authorId
    }

    set title(title) {
        this.title = title
    }
    
    set description(description) {
        this.description = description
    }

    set authorId(authorId) {
        this.authorId = authorId
    }
}