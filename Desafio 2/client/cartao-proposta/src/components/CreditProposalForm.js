import React, { useState } from 'react';
import axios from 'axios';
import { TextField, Button, Container, Typography, Box, Alert } from '@mui/material';

const CreditProposalForm = () => {
    const [clientName, setClientName] = useState('');
    const [clientEmail, setClientEmail] = useState('');
    const [creditLimit, setCreditLimit] = useState('');
    const [message, setMessage] = useState('');
    const [error, setError] = useState(false);

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            await axios.post('http://localhost:8081/api/proposals', {
                clientName,
                clientEmail,
                limit: creditLimit
            });
            setMessage('Proposta enviada com sucesso!');
            setError(false);
        } catch (error) {
            setMessage('Erro ao enviar a proposta.');
            setError(true);
            console.error(error);
        }
    };

    return (
        <Container maxWidth="sm" sx={{ mt: 4 }}>
            <Typography variant="h4" gutterBottom>
                Proposta de Cartão de Crédito
            </Typography>
            <Box component="form" onSubmit={handleSubmit} noValidate sx={{ display: 'flex', flexDirection: 'column', gap: 2 }}>
                <TextField
                    label="Nome"
                    variant="outlined"
                    value={clientName}
                    onChange={(e) => setClientName(e.target.value)}
                    required
                />
                <TextField
                    label="Email"
                    type="email"
                    variant="outlined"
                    value={clientEmail}
                    onChange={(e) => setClientEmail(e.target.value)}
                    required
                />
                <TextField
                    label="Limite de Crédito"
                    type="number"
                    variant="outlined"
                    value={creditLimit}
                    onChange={(e) => setCreditLimit(e.target.value)}
                    required
                />
                <Button variant="contained" color="primary" type="submit">
                    Enviar Proposta
                </Button>
            </Box>
            {message && (
                <Alert severity={error ? 'error' : 'success'} sx={{ mt: 2 }}>
                    {message}
                </Alert>
            )}
        </Container>
    );
};

export default CreditProposalForm;
