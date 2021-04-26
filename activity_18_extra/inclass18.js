use inclass19

db.majors.insert(
    {
        _id: 'CS', 
        description: 'Computer Science'
    }
)

db.majors.insert(
    {
        _id: 'BIOL', 
        description: 'Biology'
    }
)

db.majors.insert(
    {
        _id: 'POSC', 
        description: 'Political Science'
    }
)

db.students.insert( 
    {
        _id: 1, 
        name: 'Stephanie Schultz', 
        majors: ['CS']
    }    
)

db.students.insert( 
    {
        _id: 2, 
        name: 'Phillip Thomas', 
        majors: ['BIOL']
    }    
)

db.students.insert( 
    {
        _id: 3, 
        name: 'Christopher Smith', 
        majors: ['BIOL']
    }    
)

db.students.insert( 
    {
        _id: 4, 
        name: 'Megan Marshall', 
        majors: ['POSC', 'CS']
    }    
)

db.students.insert( 
    {
        _id: 5, 
        name: 'Michael Morales Jr.', 
        majors: ['POSC']
    }    
)