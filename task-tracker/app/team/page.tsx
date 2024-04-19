'use client'

import { useEffect, useState } from "react";
import { title } from "@/components/primitives";
import { User } from "@/models/User";
import { UserService } from "@/services/UserService";
import { Avatar, AvatarGroup, AvatarIcon } from "@nextui-org/avatar";
import { Button, Table, TableBody, TableCell, TableColumn, TableHeader, TableRow, getKeyValue } from "@nextui-org/react";

const columns = [
	{
		key: "firstName",
		label: "First Name",
	},
	{
		key: "lastName",
		label: "Last Name",
	},
	{
		key: "username",
		label: "Username",
	},
	{
		key: "email",
		label: "Email",
	},
	{
		key: "action",
		label: "",
	},
];

export default function TeamPage() {

	const [users, setUsers] = useState<User[]>([]);
	const [indice, setIndice] = useState(0);

	useEffect(() => {
		UserService.getAllUsers().then((response) => {
			setUsers(response);
		});
	}, [indice]);

	const handleDelete = (id: number) => {
		UserService.deleteUser(id).catch((error) => {
			console.error("Error deleting user:", error);
		});
		setIndice((prevIndice) => prevIndice + 1);			
	};

	return (
		<div className="w-full">
			<h1 className={`${title()} py-5`}>Team members</h1>
			<Table aria-label="Example table with dynamic content">
				<TableHeader columns={columns}>
					{columns.map((column) =>
						<TableColumn key={column.key}>{column.label}</TableColumn>
					)}
				</TableHeader>
				<TableBody>
					{users.map((user) =>
						<TableRow key={user.id}>
							<TableCell>{user.firstName}</TableCell>
							<TableCell>{user.lastName}</TableCell>
							<TableCell>{user.username}</TableCell>
							<TableCell>{user.email}</TableCell>
							<TableCell>
								<Button onClick={() => handleDelete(user.id)} className="text-tiny" variant="flat" color="danger" radius="lg" size="sm">
									delete
								</Button>
							</TableCell>
						</TableRow>
					)}
				</TableBody>
			</Table>
		</div>
	);
}
